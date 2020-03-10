package city;

public class City {
	private int postanskiBroj;
	private String ime;
	public City(String ime, int postanskiBroj) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.ime = ime;
	}
	public City() {
		super();
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postanskiBroj;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (postanskiBroj != other.postanskiBroj)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "City [postanskiBroj=" + postanskiBroj + ", ime=" + ime + "]";
	}
	
}
