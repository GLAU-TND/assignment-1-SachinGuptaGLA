package definition;

 public class person {

     private String contactFirstName;
     private String contactLastName;
     private String[] contactNumber;
     private String emailOfContact;

     public person(String contactFirstName, String contactLastName, String[] contactNumber, String emailOfContact) {
         this.contactFirstName = contactFirstName;
         this.contactLastName = contactLastName;
         this.contactNumber = contactNumber;
         this.emailOfContact = emailOfContact;
     }

     public String getContactFirstName() {
         return contactFirstName;
     }

     public String getContactLastName() {
         return contactLastName;
     }

     public String[] getContactNumber() {
         return contactNumber;
     }

     public String getEmailOfContact() {
         return emailOfContact;
     }


     public void setContactFirstName(String contactFirstName) {
         this.contactFirstName = contactFirstName;
     }

     public void setContactLastName(String contactLastName) {
         this.contactLastName = contactLastName;
     }

     public void setContactNumber(String[] contactNumber) {
         this.contactNumber = contactNumber;
     }

     public void setEmailOfContact(String emailOfContact) {
         this.emailOfContact = emailOfContact;
     }



     public String toString(){

         final StringBuffer strafe = new StringBuffer("-------- * -------- * -------- * --------\n");
         strafe.append("First Name: ").append(contactFirstName).append("\n");
         strafe.append("Last Name: ").append(contactLastName).append("\n");
         strafe.append("Contact Number(s): ");//.append("\n");
         for (int i =0 ; i<contactNumber.length ; i++){
             strafe.append((contactNumber[0] != null && i == 0 ? contactNumber[0] : "") + (contactNumber[1] != null && i == 1 ? ", " + contactNumber[1] : "") +
                     (contactNumber[2] != null && i == 2 ? ", " + contactNumber[i] : ""));

         }
         strafe.append("\nEmail Address: ").append(emailOfContact).append("\n");
         strafe.append("-------- * -------- * -------- * --------");
         return strafe.toString();

     }


 }

