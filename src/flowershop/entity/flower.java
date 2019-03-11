package flowershop.entity;

public class flower {
	
	public  String fid;//��ID
    public  String fname;//������
    public  String fkind;//��������
    public  double fprice;//���ļ۸�
    public  int fstocksum;//���Ŀ��ʣ����
    public  int fsalesum;//����������
    public  boolean isOnsale;//���¼����
    
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
	
	public void print() {//��ӡ������Ϣ
		System.out.print(fid+"\t"+fname+"\t"+fkind+"\t"+fprice+"\t"+fstocksum+"\t"+fsalesum+"\t");
		
		if(isOnsale) {
			System.out.println("�ϼ�");
		}
		else {
			System.out.println("�¼�"
					+ "");
		}
	}

}