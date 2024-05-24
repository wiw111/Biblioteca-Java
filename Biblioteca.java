import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Biblioteca extends JFrame {
    private Connection connection;
    private JTextField idLibroField, tituloField, autorField, isbnField, editorialField, anyPublicacioField, categoriaField;
    private JTextField idUsuarioField, nombreField, apellidosField, emailField, telefonoField, rolField;
    private JTextField idPrestecField, idLibroPrestecField, idUsuarioPrestecField, dataPrestecField, dataRetornPrevistaField, dataRetornRealField;

    public Biblioteca() {
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "usuario", "contraseña");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configurar la interfaz gráfica
        setTitle("Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel de Libros
        JPanel librosPanel = new JPanel(new GridLayout(9, 2));
        librosPanel.add(new JLabel("ID Libro:"));
        idLibroField = new JTextField();
        librosPanel.add(idLibroField);L'objectiu de la pràctica serà fer una Agenda telefònica que emmagatzema la informació en una base de dades local en MySQL. Utilitza la interfície gràfica Swing.

        Els camps de la Base de Dades com a mínim són: Nom, cognoms, telèfons i direcció.
        
        S'ha de fer:
        
        Una taula que mostri tots els contactes.
         Donar d'alta un contacte.
        Modificar un contacte.
        Esborrar un contacte.
        Veure un contacte.
        librosPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        librosPanel.add(tituloField);
        librosPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        librosPanel.add(autorField);
        librosPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        librosPanel.add(isbnField);
        librosPanel.add(new JLabel("Editorial:"));
        editorialField = new JTextField();
        librosPanel.add(editorialField);
        librosPanel.add(new JLabel("Año Publicación:"));
        anyPublicacioField = new JTextField();
        librosPanel.add(anyPublicacioField);
        librosPanel.add(new JLabel("Categoría:"));
        categoriaField = new JTextField();
        librosPanel.add(categoriaField);

        JButton addBookButton = new JButton("Añadir Libro");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        librosPanel.add(addBookButton);

        JButton editBookButton = new JButton("Editar Libro");
        editBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editBook();
            }
        });
        librosPanel.add(editBookButton);

        JButton deleteBookButton = new JButton("Eliminar Libro");
        deleteBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
        librosPanel.add(deleteBookButton);

        tabbedPane.addTab("Libros", librosPanel);

        // Panel de Usuarios
        JPanel usuariosPanel = new JPanel(new GridLayout(8, 2));
        usuariosPanel.add(new JLabel("ID Usuario:"));L'objectiu de la pràctica serà fer una Agenda telefònica que emmagatzema la informació en una base de dades local en MySQL. Utilitza la interfície gràfica Swing.

        Els camps de la Base de Dades com a mínim són: Nom, cognoms, telèfons i direcció.
        
        S'ha de fer:
        
        Una taula que mostri tots els contactes.
         Donar d'alta un contacte.
        Modificar un contacte.
        Esborrar un contacte.
        Veure un contacte.
        idUsuarioField = new JTextField();
        usuariosPanel.add(idUsuarioField);
        usuariosPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        usuariosPanel.add(nombreField);
        usuariosPanel.add(new JLabel("Apellidos:"));
        apellidosField = new JTextField();
        usuariosPanel.add(apellidosField);
        usuariosPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        usuariosPanel.add(emailField);
        usuariosPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        usuariosPanel.add(telefonoField);
        usuariosPanel.add(new JLabel("Rol:"));
        rolField = new JTextField();
        usuariosPanel.add(rolField);

        JButton addUserButton = new JButton("Añadir Usuario");
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        usuariosPanel.add(addUserButton);

        JButton editUserButton = new JButton("Editar Usuario");
        editUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editUser();
            }
        });
        usuariosPanel.add(editUserButton);

        JButton deleteUserButton = new JButton("Eliminar Usuario");
        deleteUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });
        usuariosPanel.add(deleteUserButton);

        tabbedPane.addTab("Usuarios", usuariosPaneconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");
        l);

        // Panel de Préstamos
        JPanel prestecsPanel = new JPanel(new GridLayout(8, 2));
        prestecsPanel.add(new JLabel("ID Préstamo:"));
        idPrestecField = new JTextField();
        prestecsPanel.add(idPrestecField);
        prestecsPanel.add(new JLabel("ID Libro:"));
        idLibroPrestecField = new JTextField();
        prestecsPanel.add(idLibroPrestecField);
        prestecsPanel.add(new JLabel("ID Usuario:"));
        idUsuarioPrestecField = new JTextField();
        prestecsPanel.add(idUsuarioPrestecField);
        prestecsPanel.add(new JLabel("Fecha Préstamo:"));
        dataPrestecField = new JTextField();
        prestecsPanel.add(dataPrestecField);
        prestecsPanel.add(new JLabel("Fecha Retorno Prevista:"));
        dataRetornPrevistaField = new JTextField();
        prestecsPanel.add(dataRetornPrevistaField);
        prestecsPanel.add(new JLabel("Fecha Retorno Real:"));
        dataRetornRealField = new JTextField();
        prestecsPanel.add(dataRetornRealField);

        JButton addPrestecButton = new JButton("Añadir Préstamo");
        addPrestecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPrestec();
            }
        });
        prestecsPanel.add(addPrestecButton);

        JButton editPrestecButton = new JButton("Editar Préstamo");
        editPrestecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editPrestec();
            }
        });
        prestecsPanel.add(editPrestecButton);

        JButton deletePrestecButton = new JButton("Eliminar Préstamo");
        deletePrestecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePrestec();
            }
        });
        prestecsPanel.add(deletePrestecButton);

        tabbedPane.addTab("Préstamos", prestecsPanel);

        add(tabbedPane);
    }

    private void addBook() {
        try {
            String query = "INSERT INTO libros (ID_Llibre, Títol, Autor, ISBN, Editorial, Any_Publicació, Categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idLibroField.getText()));
            statement.setString(2, tituloField.getText());
            statement.setString(3, autorField.getText());
            statement.setString(4, isbnField.getText());
            statement.setString(5, editorialField.getText());
            statement.setInt(6, Integer.parseInt(anyPublicacioField.getText()));
            statement.setString(7, categoriaField.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editBook() {
        try {
            String query = "UPDATE libros SET Títol = ?, Autor = ?, ISBN = ?, Editorial = ?, Any_Publicació = ?, Categoria = ? WHERE ID_Llibre = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tituloField.getText());
            statement.setString(2, autorField.getText());
            statement.setString(3, isbnField.getText());
            statement.setString(4, editorialField.getText());
            statement.setInt(5, Integer.parseInt(anyPublicacioField.getText()));
            statement.setString(6, categoriaField.getText());
            statement.setInt(7, Integer.parseInt(idLibroField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteBook() {
        try {
            String query = "DELETE FROM libros WHERE ID_Llibre = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idLibroField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUser() {
        try {
            String query = "INSERT INTO usuarios (ID_Usuario, Nombre, Apellidos, Email, Teléfono, Rol) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idUsuarioField.getText()));
            statement.setString(2, nombreField.getText());
            statement.setString(3, apellidosField.getText());
            statement.setString(4, emailField.getText());
            statement.setString(5, telefonoField.getText());
            statement.setString(6, rolField.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editUser() {
        try {
            String query = "UPDATE usuarios SET Nombre = ?, Apellidos = ?, Email = ?, Teléfono = ?, Rol = ? WHERE ID_Usuario = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombreField.getText());
            statement.setString(2, apellidosField.getText());
            statement.setString(3, emailField.getText());
            statement.setString(4, telefonoField.getText());
            statement.setString(5, rolField.getText());
            statement.setInt(6, Integer.parseInt(idUsuarioField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser() {
        try {
            String query = "DELETE FROM usuarios WHERE ID_Usuario = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idUsuarioField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    private void addPrestec() {   
        try (L'objectiu de la pràctica serà fer una Agenda telefònica que emmagatzema la informació en una base de dades local en MySQL. Utilitza la interfície gràfica Swing.)

        Els camps de la Base de Dades com a mínim són: Nom, cognoms, telèfons i direcció.
        
        S'ha de fer:
        
        Una taula que mostri tots els contactes.
         Donar d'alta un contacte.
        Modificar un contacte.
        Esborrar un contacte.
        Veure un contacte.
            String query = "INSERT INTO prestecs (ID_Prestec, ID_Llibre, ID_Usuario, Data_Prestec, Data_Retorn_Prevista, Data_Retorn_Real) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idPrestecField.getText()));
            statement.setInt(2, Integer.parseInt(idLibroPrestecField.getText()));
            statement.setInt(3, Integer.parseInt(idUsuarioPrestecField.getText()));
            statement.setString(4, dataPrestecField.getText());
            statement.setString(5, dataRetornPrevistaField.getText());
            statement.setString(6, dataRetornRealField.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editPrestec() {
        try {
            String query = "UPDATE prestecs SET ID_Llibre = ?, ID_Usuario = ?, Data_Prestec = ?, Data_Retorn_Prevista = ?, Data_Retorn_Real = ? WHERE ID_Prestec = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idLibroPrestecField.getText()));
            statement.setInt(2, Integer.parseInt(idUsuarioPrestecField.getText()));
            statement.setString(3, dataPrestecField.getText());
            statement.setString(4, dataRetornPrevistaField.getText());
            statement.setString(5, dataRetornRealField.getText());
            statement.setInt(6, Integer.parseInt(idPrestecField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletePrestec() {
        try {
            String query = "DELETE FROM prestecs WHERE ID_Prestec = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idPrestecField.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }
}
