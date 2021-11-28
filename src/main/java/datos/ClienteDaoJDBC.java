package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT idsolicitud_cliente, Categoria, Variedad, Grado, Color, Nombre_empresa "
            + " FROM solicitud_cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT idsolicitud_cliente, Categoria, Variedad, Grado, Color, Nombre_empresa "
            + " FROM solicitud_cliente WHERE idsolicitud_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO solicitud_cliente(Categoria, Variedad, Grado, Color, Nombre_empresa) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE solicitud_cliente "
            + " SET Categoria=?, Variedad=?, Grado=?, Color=?, Nombre_empresa=? WHERE idsolicitud_cliente=?";

    private static final String SQL_DELETE = "DELETE FROM solicitud_cliente WHERE idsolicitud_cliente = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idsolicitud_cliente = rs.getInt("idsolicitud_cliente");
                String Categoria = rs.getString("Categoria");
                String Variedad = rs.getString("Variedad");
                String Grado = rs.getString("Grado");
                String Color = rs.getString("Color");
                String Nombre_empresa = rs.getString("Nombre_empresa");

                cliente = new Cliente(idsolicitud_cliente, Categoria, Variedad, Grado, Color, Nombre_empresa);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdsolicitud_cliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String categoria = rs.getString("Categoria");
            String variedad = rs.getString("Variedad");
            String grado = rs.getString("Grado");
            String color = rs.getString("Color");
            String nombre_empresa = rs.getString("Nombre_empresa");

            cliente.setCategoria(categoria);
            cliente.setVariedad(variedad);
            cliente.setGrado(grado);
            cliente.setColor(color);
            cliente.setNombre_empresa(nombre_empresa);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getCategoria());
            stmt.setString(2, cliente.getVariedad());
            stmt.setString(3, cliente.getGrado());
            stmt.setString(4, cliente.getColor());
            stmt.setString(5, cliente.getNombre_empresa());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getCategoria());
            stmt.setString(2, cliente.getVariedad());
            stmt.setString(3, cliente.getGrado());
            stmt.setString(4, cliente.getColor());
            stmt.setString(5, cliente.getNombre_empresa());
            stmt.setInt(6, cliente.getIdsolicitud_cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdsolicitud_cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}