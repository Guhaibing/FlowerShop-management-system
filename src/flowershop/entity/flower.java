package flowershop.entity;

public class flower {
	
	public  String fid;//花ID
    public  String fname;//花名称
    public  String fkind;//花的种类
    public  double fprice;//花的价格
    public  int fstocksum;//花的库存剩余量
    public  int fsalesum;//花的销售量
    public  boolean isOnsale;//上下架情况
    
    public flower(String fid,String fname,String fkind,double fprice,int fstocksum,int fsalesum,boolean isOnsale) {
    	this.fid = fid;
    	this.fkind = fkind;
    	this.fname = fname;
    	this.fprice = fprice;
    	this.fsalesum = fsalesum;
    	this.fstocksum = fstocksum;
    	this.isOnsale = isOnsale;
    }
    public flower() {
    	fid = null;
    	fname = null;
    	fkind = null;
    	fprice = 0;
    	fstocksum = 0;
    	fsalesum = 0;
    	isOnsale = false;
    }
    public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFkind() {
		return fkind;
	}
	public void setFkind(String fkind) {
		this.fkind = fkind;
	}
	public double getFprice() {
		return fprice;
	}
	public void setFprice(double price) {
		this.fprice = price;
	}
	public int getFstocksum() {
		return fstocksum;
	}
	public void setFstocksum(int fstocksum) {
		this.fstocksum = fstocksum;
	}
	public int getFsalesum() {
		return fsalesum;
	}
	public void setFsalesum(int fsalesum) {
		this.fsalesum = fsalesum;
	}
	public boolean isOnsale() {
		return isOnsale;
	}
	public void setOnsale(boolean isOnsale) {
		this.isOnsale = isOnsale;
	}
	
	public void print() {//打印花的信息
		System.out.print(fid+"\t"+fname+"\t"+fkind+"\t"+fprice+"\t"+fstocksum+"\t"+fsalesum+"\t");
		
		if(isOnsale) {
			System.out.println("上架");
		}
		else {
			System.out.println("下架"
					+ "");
		}
	}

}