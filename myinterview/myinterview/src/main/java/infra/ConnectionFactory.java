package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Criando a classe que relaciona a aplicação com o banco de dados
public class ConnectionFactory {

    //Precisa ser privado para evitar novas intâncias que podem ser geradas
    private ConnectionFactory() {}

    //JBDC é um recurso que o java utiliza para conseguir conectar com o DB
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/filmes_teste","root","megaman105");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", ex);
        }
    }
}

