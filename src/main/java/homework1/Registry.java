package homework1;

public class Registry {
    private Patient patient;
    private Archive archive;
    private BuildingPlan buildingPlan;
    private DoctorSchedule doctorSchedule;
    private Doctor doctor;
    public void takePatient(Patient patient) {
        this.patient = patient;
        System.out.println("Регистратура: {");
        goToArchive();
        getDoctorSchedule();
        goToBuildingPlan();
        System.out.println("}");
        sendPatientToDoctor();
    }

    public void goToArchive(){
        archive.getMedicalCard(patient.getNumberPatient());
    }

    public void getDoctorSchedule(){
        doctorSchedule.getTicket(patient.getNumberPatient());
    }

    public void goToBuildingPlan(){
        buildingPlan.getRoute(patient.getNumberPatient());
    }

    private void sendPatientToDoctor() {
        doctor.takePatient(patient);
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public void setBuildingPlan(BuildingPlan buildingPlan) {
        this.buildingPlan = buildingPlan;
    }

    public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
