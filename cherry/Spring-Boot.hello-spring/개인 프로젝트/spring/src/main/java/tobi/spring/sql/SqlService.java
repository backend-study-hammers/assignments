package tobi.spring.sql;

public interface SqlService {
    String getSql(String key) throws SqlRetirevalFailureException;
}
