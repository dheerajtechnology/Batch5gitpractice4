package POJOMapper;

public class CreatingUser {
	
	
	public static Object createUser()
	{
		CreatingUserPOJO emp=new CreatingUserPOJO();
		
		emp.setId(12346);
		emp.setLocation("Hyderabad");
		emp.setName("harry");
		emp.setJob("manager");
		
		return emp;
	}
}
