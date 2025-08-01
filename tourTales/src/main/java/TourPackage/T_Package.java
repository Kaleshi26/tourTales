package TourPackage;

public class T_Package {

	
	int id;
	String packName;
	String packType;
	int days;
	double pBudget;
	
	
	
	
	
	@Override
	public String toString() {
		return "T_Package [id=" + id + ", packName=" + packName + ", packType=" + packType + ", days=" + days
				+ ", pBudget=" + pBudget + "]";
	}
	public T_Package(String packName, String packType, int days, double pBudget) {
		super();
		this.packName = packName;
		this.packType = packType;
		this.days = days;
		this.pBudget = pBudget;
	}
	public T_Package() {
		super();
	}
	public T_Package(int id, String packName, String packType, int days, double pBudget) {
		super();
		this.id = id;
		this.packName = packName;
		this.packType = packType;
		this.days = days;
		this.pBudget = pBudget;
	}
	public int getId() {
		return id;
	}
	public String getPackName() {
		return packName;
	}
	public String getPackType() {
		return packType;
	}
	public int getDays() {
		return days;
	}
	public double getpBudget() {
		return pBudget;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public void setpBudget(double pBudget) {
		this.pBudget = pBudget;
	}
	
	
	
}
