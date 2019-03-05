package Database;

import Database.DBConnectivity.*;

public class DBImplementation implements write {

	public connection connect() {
		// TODO - implement DBImplementation.connect
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SQL
	 * @param conn
	 */
	public resultSet read(String SQL, connection conn) {
		// TODO - implement DBImplementation.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SQL
	 * @param conn
	 */
	public boolean write(String SQL, connection conn) {
		// TODO - implement DBImplementation.write
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param conn
	 */
	public boolean disconnect(connection conn) {
		// TODO - implement DBImplementation.disconnect
		throw new UnsupportedOperationException();
	}

}