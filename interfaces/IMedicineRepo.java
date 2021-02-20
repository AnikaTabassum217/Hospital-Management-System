package interfaces;

import java.lang.*;
import entity.*;

public interface IMedicineRepo{
	
	Medicine getMedicine(String ID );
	void insertMedicine(Medicine m);
	void updateMedicine(Medicine m);
	void deleteMedicine(String ID);
}