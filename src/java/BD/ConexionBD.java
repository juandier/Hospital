package BD;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leonardo
 */
public class ConexionBD {
    
    public static Connection conexion=null ;
    private  String nombreBD="";
    private final String driver = "com.mysql.jdbc.Driver";
    public ConexionBD(String nombreBD) throws ClassNotFoundException            
    {
        this.nombreBD=nombreBD;
        if(conexion==null)
        {
            try {
                   Class.forName(driver);
                conexion= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+nombreBD+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8", "root","");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public  void cerrarConexion()
    {
        if(conexion!=null)
        {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //ejemplo de una inserccion;
    public void insertarDatos(String sql)
    {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement(sql);
            /*AQUI VA EL 
            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "mkyong");
            preparedStatement.setString(3, "system");
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();*/            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarCitas(java.sql.Date dia, java.sql.Time hora,String nombre
            ,String apellidos,String telefono,String descripcion,String nss,int idMedico)
    {
        PreparedStatement insertar ;
       try {
            insertar = conexion.prepareStatement("insert into cita (dia,hora,nombre,apellidos,telefono,descripcion,nss,idMedico) values (?,?,?,?,?,?,?,?)");
            
            insertar.setDate(1, dia);
            insertar.setTime(2, hora);
            insertar.setString(3, nombre);
            insertar.setString(4, apellidos);
            insertar.setString(5, telefono);
            insertar.setString(6, descripcion);
            insertar.setString(7, nss);
            insertar.setInt(8, idMedico);
            insertar.executeUpdate();                                         
        } catch (SQLException ex) {
            System.out.println("no funciono query insertar");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarDatos(String sql)
    {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ArrayList<String[]> consulta(String sql) {
        
        ArrayList<String[]> datos = new ArrayList<String[]>();
          PreparedStatement consulta;
        System.out.println("Consulta : " + sql + "\n"); // Declaracion en null del resultSet
        try {
            int registros = 0; //Variable para contar los registros
            consulta = conexion.prepareStatement(sql); //Preparo la sentencia sql a ejecutar
            ResultSet rs = consulta.executeQuery(); //Obtengo los datos de la consulta en un resultset
            //Guardo los datos del ResultSet en un ResultSetMetadata para jugar un poco mas
            ResultSetMetaData rsm = rs.getMetaData();
            //Obtengo los nombres de las columnas: D
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                System.out.print("" + rsm.getColumnName(i) + " | ");
            }

            System.out.println("");
            while (rs.next()) {
                String[] fila = new String[rsm.getColumnCount()];
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + " | ");
                    fila[i-1] = rs.getString(i);
                }
                registros++;
                System.out.println("");
                
                datos.add(fila);
            }
            System.out.println("\nCantidad de registros : " + registros);
            System.out.println("------------------------------------------------- \n");
            consulta.close(); //Libero datos del PreparedStatement, tambien se libera el ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Capturo la excepcion en caso de error
        }        
        return datos;
    }
     
     public void insertarHora(String hora)
     {
         PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("insert into cita values (?) where nss=123456");
            consulta.setString(1, hora);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
