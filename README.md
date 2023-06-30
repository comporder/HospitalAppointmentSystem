# HospitalAppointmentSystem

The hospital appointment system project is an automation system that allows users to schedule and manage doctor appointments. It provides functionality for patients to book appointments, doctors to manage their schedules, and keeps track of the appointment calendar.

The project is composed of the following classes:

Insan (Person): This class represents individuals, including patients and doctors. It stores the name and surname of each person.

Doktor (Doctor): This class represents doctors. It extends the Insan class and includes additional information such as their specialization. Doctors are associated with clinics.

Klinik (Clinic): This class represents clinics. Each clinic has a clinic number and is assigned to a doctor.

Tarih (Date): This class represents dates. It stores the day, month, and year as separate integer values. It also provides functionality for date comparison and string representation.

Randevu (Appointment): This class represents appointments. Each appointment has a unique appointment ID, a doctor, a date, and a time. It also provides a string representation of the appointment.

Sehir (City): This class represents cities. It stores the name of the city and its plate number.

By combining these classes, the hospital appointment system is created. For example, patients can select a doctor, choose a date and time, and create an appointment. Appointments can be associated with clinics, and information about doctors and clinics can be accessed. The Tarih class provides date comparison functionality, and the Randevu class provides a string representation of appointments.

To fully understand the project's functionality and user interface, further details and additional classes related to user input, database operations, and the user interface need to be examined. The provided classes represent the basic structure and information of the project.
