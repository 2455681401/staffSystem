package util.comparator;

import java.util.Comparator;
import java.util.Map;

import entity.Employee;

public class EmpNameComparator implements Comparator<Long>{
	private Map<Long, Employee> map;
	public EmpNameComparator(Map<Long, Employee> map) {
		this.map = map;
	}
	@Override
	public int compare(Long o1, Long o2) {
		Employee emp1 = map.get(o1);
		Employee emp2 = map.get(o2);
		return emp1.getName().compareTo(emp2.getName());
	}
	
}
