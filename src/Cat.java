
public class Cat {
			 private int YearsOld;
			 
			 Cat (int YearsOld){
				 this.YearsOld = YearsOld;
				 }
			 public int getYearsOld() {
				 return this.YearsOld;
			 }
			 public void setYearsOld (int YearsOld) {
				 if (YearsOld>0) {
					 this.YearsOld = YearsOld;
				 }
		 }
	}

