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
void Employee_init (Employee *self,int pid,int born,int afm,in