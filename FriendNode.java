package reconnecter;

public class FriendNode {
	
	public String name;
	public int days;
	public FriendNode next;
	
	public FriendNode(String name, int days, FriendNode next) {
		this.name = name;
		this.days = days;
		this.next = next;
	}
	
	public FriendNode(String name, int days) {
		this.name = name;
		this.days = days;
		this.next = null;
	}
	
	public String toString() {
		return name + " " + days;
	}

	public boolean hasNext() {
		if (next == null) {
			return false;
		}
		return true;
	}
}
