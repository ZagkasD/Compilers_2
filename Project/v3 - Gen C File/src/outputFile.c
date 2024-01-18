#include <stdio.h>

typedef struct{ 
	int pid;
	int born;
}Person;
void Person_init (Person *self,int pid,int born) {
		self->pid = pid;
		self->born = born;

}
int  Person_getPid (Person *self) {
		return self->pid;

}
int  Person_getBorn (Person *self) {
		return self->born;

}
int  Person_millenium (Person *self) {
		if (self->born<2000){
			return 1;
		}
		else {
			return 2;
		}

}

typedef struct{ 
	Person base;
	int afm;
	int department;
}Employee;
void Employee_init (Employee *self,int pid,int born,int afm,int department) {
		Person_init((Person*)self, pid, born);
		self->afm = afm;
		self->department = department;

}
int  Employee_getDepartment (Employee *self) {
		return self->department;

}
void  Employee_setDepartment (Employee *self,int department) {
		self->department = department;

}
int  Employee_getPid (Employee *self) {
		return self->afm;

}

typedef struct{ 
	Employee *employee;
}StupidPrint;
void StupidPrint_init (StupidPrint *self, Employee *employee) {
	self->employee = employee;
		printf ("%d \n",self->employee->base.pid);
		printf ("%d \n",self->employee->base.born);
		printf ("%d \n",self->employee->afm);
		printf ("%d \n",self->employee->department);

}
int main(){
	Person	george;
	Person_init(&george, 200223,2002);
	Person	john;
	Person_init(&john, 200055,2000);
	Employee	peter;
	Employee_init(&peter, 200122,2001,990122,1);
	printf ("%d \n",Person_getBorn(&george  ));
	printf ("%d \n",Person_getBorn(&john  ));
	printf ("%d \n",Person_getBorn((Person *)&peter  ));
	printf ("%d \n",Person_millenium((Person *)&peter  ));
	printf ("%d \n",Employee_getDepartment(&peter  ));
Employee_setDepartment(&peter, 2);
	printf ("%d \n",Employee_getDepartment(&peter  ));
	printf ("%d \n",Person_getPid(&george  ));
	printf ("%d \n",Employee_getPid(&peter  ));
	StupidPrint	stupid;
	StupidPrint_init(&stupid  ,&peter);
	return 0;
}
