
public class CommissionEmployee extends Employee{
	
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber
			, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber, commissionRate);
		if (commissionRate <= 0.0 || commissionRate >= 1.0){
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		if (grossSales < 0.0){
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	@Override
	public double earning() {
		return getCommissionRate() * getGrossSales();
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0){
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0){
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	}

	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "CommissionEmployee", super.toString()
				, "grossSales", getGrossSales(), "CommissionRate", getCommissionRate() );
				
	}
	
	

}
