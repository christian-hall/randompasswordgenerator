import java.time.LocalDateTime;

public class Password {
	private int id;
	private String password;
	private LocalDateTime timestamp;
	
	public Password(int id, String password, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.password = password;
		this.timestamp = timestamp;
	}
	
	public Password() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Password [id=" + id + ", password=" + password + ", timestamp=" + timestamp + "]";
	}
}
