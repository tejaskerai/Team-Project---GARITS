package Database;

public interface DBConnectivity {

	abstract void read();

	abstract void write();

	abstract void connect();

	abstract void disconnect();

}