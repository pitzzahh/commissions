package criminal;

import java.util.Objects;

public class Criminal {

    private String name;
    private String age;
    private String gender;
    private String address;
    private String crimeCommitted;
    private String policeId;
    private String policeRank;
    private String detainedStation;
    private String lengthOfImprisonment;
    private boolean isDetained;

    public Criminal() {
    }

    public Criminal(String name, String age, String gender, String address, String crimeCommitted, String policeId, String policeRank, String detainedStation, String lengthOfImprisonment, boolean isDetained) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.crimeCommitted = crimeCommitted;
        this.policeId = policeId;
        this.policeRank = policeRank;
        this.detainedStation = detainedStation;
        this.lengthOfImprisonment = lengthOfImprisonment;
        this.isDetained = isDetained;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrimeCommitted() {
        return crimeCommitted;
    }

    public void setCrimeCommitted(String crimeCommitted) {
        this.crimeCommitted = crimeCommitted;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getPoliceRank() {
        return policeRank;
    }

    public void setPoliceRank(String policeRank) {
        this.policeRank = policeRank;
    }

    public String getDetainedStation() {
        return detainedStation;
    }

    public void setDetainedStation(String detainedStation) {
        this.detainedStation = detainedStation;
    }

    public String getLengthOfImprisonment() {
        return lengthOfImprisonment;
    }

    public void setLengthOfImprisonment(String lengthOfImprisonment) {
        this.lengthOfImprisonment = lengthOfImprisonment;
    }

    public boolean isDetained() {
        return isDetained;
    }

    public void setDetained(boolean detained) {
        this.isDetained = detained;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Criminal)) return false;
        Criminal criminal = (Criminal) o;
        return isDetained() == criminal.isDetained() && getName().equals(criminal.getName()) && getAge().equals(criminal.getAge()) && getGender().equals(criminal.getGender()) && getAddress().equals(criminal.getAddress()) && getCrimeCommitted().equals(criminal.getCrimeCommitted()) && getPoliceId().equals(criminal.getPoliceId()) && getPoliceRank().equals(criminal.getPoliceRank()) && getDetainedStation().equals(criminal.getDetainedStation()) && getLengthOfImprisonment().equals(criminal.getLengthOfImprisonment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGender(), getAddress(), getCrimeCommitted(), getPoliceId(), getPoliceRank(), getDetainedStation(), getLengthOfImprisonment(), isDetained());
    }

    @Override
    public String toString() {
        return "Name                 : " + getName() + "\n" +
               "Age                  : " + getAge() + "\n" +
               "Gender               : " + getGender() + "\n" +
               "Address              : " + getAddress() + "\n" +
               "Crime Committed      : " + getCrimeCommitted() + "\n" +
               "Police ID            : " + getPoliceId() + "\n" +
               "Police Rank          : " + getPoliceRank() + "\n" +
               "Detained Station     : " + getDetainedStation() + "\n" +
               "Years of imprisonment: " + getLengthOfImprisonment() + "\n" +
               "Is detained          : " + isDetained() + "\n";
    }

}