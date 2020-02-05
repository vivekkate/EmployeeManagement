package com.zensar.emdb.dao;
import java.util.ArrayList;

public interface EmployeeInterface<T,P,Q> {
				T insert(P obj);
				T delete(P obj);
				T modifySalary(P obj);
				T modifyDesignation(P obj);
				P DisplayOne(P obj);
				Q DisplayAll();
				
}
