/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baserelacional;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class BaseRelacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conexion = conexion();

            String[] cod = {"p1", "p2", "p3"};
            String[] desc = {"parafusos", "cravos", "tachas"};
            int[] prezo = {3, 4, 5};

            // insertar productos
            /*for (int i = 0; i < cod.length; i++) {
                insireProduto(conexion, cod[i], desc[i], prezo[i]);
            }*/
            
            // listar prodcutos
            listaProdutos(conexion);
            
            // actualizar precio
            actualizaPre(conexion, "p2", 3000);
            listaProdutos(conexion);
            
            // borrar fila
            borrarFila(conexion, "p2");
            listaProdutos(conexion);
            
            // mostrar fila
            amosarFila(conexion, "p1");
            
            // cierra conexion
            pecharConexion(conexion);

        } catch (SQLException ex) {
            Logger.getLogger(BaseRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // - crear un metodo de nome 'conexion'  que permita conectarse a base orcl mediante o usuario hr password hr 
    public static Connection conexion() throws SQLException, ClassNotFoundException {
        System.out.println("----Conectando a la base----");
        Class.forName("oracle.jdbc.OracleDriver");

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        //String url = driver + "@" + host + ":" + porto + ":" + sid;
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
        Connection conn = DriverManager.getConnection(url);
        
        System.out.println("----Conexion satisfactoria----");
        return conn;
    }

    // -crear un metodo de nome 'insireProduto'  que permita inserir na taboa produtos unha fila pasandolle como parametros o codigo o nome e o prezo dun produto
    public static void insireProduto(Connection conexion, String codigo, String nome, int prezo) throws SQLException, ClassNotFoundException {
        System.out.println("----Insertando producto " + nome + "----");
        
        String sql = "INSERT INTO produtos VALUES(?, ?, ?)";
        PreparedStatement insertarProducto = conexion.prepareStatement(sql);
        insertarProducto.setString(1, codigo);
        insertarProducto.setString(2, nome);
        insertarProducto.setInt(3, prezo);
        insertarProducto.executeUpdate();
        
        System.out.println("----Producto " + nome + " insertado----");

        
    }

    // - crear un metodo chamdo 'listaProdutos' que amose o contido dos rexistros que hai na base  (debe usarse crearse un resulSet e volcar o contido do mesmo ) 
    public static void listaProdutos(Connection conexion) throws SQLException, ClassNotFoundException {
        System.out.println("----Listando productos----");

        String sql = "SELECT * FROM produtos";

        ResultSet rs = conexion.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            String codigo = rs.getString("codigo");
            String nome = rs.getString("descricion");
            int prezo = rs.getInt("prezo");

            System.out.println("Producto:\nCodigo: " + codigo + ", Nombre: " + nome + ", Precio: " + prezo + "€");
        }

    }

    // - Crear un método de nome 'actualizaPre' tal que pasandolle o codigo e prezo dun rexistro actualize o campo  prezo do rexistro  que corresponde a dito  codigo. 
    public static void actualizaPre(Connection conexion, String codigo, int prezo) throws SQLException, ClassNotFoundException {
        System.out.println("----Actualizando precio----");
        
        String sql = "UPDATE produtos SET prezo = ? WHERE codigo = ?";
        PreparedStatement updateProducto = conexion.prepareStatement(sql);
        updateProducto.setString(2, codigo);
        updateProducto.setInt(1, prezo);
        updateProducto.executeUpdate();
    }

    // - Crear un método de nome ‘borrarfila’ tal que pasandolle o codigo dunha fila elimine dita fila da taboa produtos.
    public static void borrarFila(Connection conexion, String codigo) throws SQLException, ClassNotFoundException {
        System.out.println("----Borrando fila----");
        
        String sql = "DELETE from produtos WHERE codigo = ?";
        PreparedStatement borrarProducto = conexion.prepareStatement(sql);
        borrarProducto.setString(1, codigo);
        borrarProducto.executeUpdate();
    }

    //- Crear un método de nome ‘amosarFila’ tal que pasandolle o codigo dunha fila amose o contido dos seus campos
    public static void amosarFila(Connection conexion, String codigo) throws SQLException, ClassNotFoundException {
        System.out.println("----Mostrando entrada----");
        String sql = "SELECT * FROM produtos WHERE codigo = '" + codigo + "'";

        ResultSet rs = conexion.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            codigo = rs.getString("codigo");
            String nome = rs.getString("descricion");
            int prezo = rs.getInt("prezo");

            System.out.println("Producto:\nCodigo: " + codigo + ", Nombre: " + nome + ", Precio: " + prezo + "€");
        }
    }

    public static void pecharConexion(Connection conexion) throws SQLException {
        System.out.println("----Conexion cerrada----");
        conexion.close();
    }

}
