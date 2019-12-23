package jogador;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

@JDBI
public interface JogadorQueries {

    @SqlQuery("select idjogador, nomejogador, mestre from jogador where login = :login")
    Jogador findByLogin(@Bind("login")String login);
}
