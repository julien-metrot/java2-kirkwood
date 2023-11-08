package com.metrot.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Comparable<User> {
    @JsonProperty("name")
    private Name name;

    @JsonProperty("login")
    private Login login;
    @JsonProperty("dob")
    private Dob dob;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("nat")
    private String nat;

    public Name getName() {
        return name;
    }

    public Login getLogin() {
        return login;
    }

    public Dob getDob() {
        return dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getCell() {
        return cell;
    }

    public String getNat() {
        return nat;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                "\n\tlogin=" + login +
                "\n\tdob=" + dob +
                "\n\tregistered=" + registered +
                "\n\tid=" + id +
                "\n\tpicture=" + picture +
                "\n\tlocation=" + location +
                "\n\temail='" + email + '\'' +
                "\n\tphone='" + phone + '\'' +
                "\n\tgender='" + gender + '\'' +
                "\n\tcell='" + cell + '\'' +
                "\n\tnat='" + nat + '\'' +
                "}\n\t";
    }

    @Override
    public int compareTo(User o) {
        int result = this.getName().getLast().compareTo(o.getName().getLast());
        if (result == 0) {
            result = this.getName().getFirst().compareTo(o.getName().getFirst());
        }
        return result;
    }
}
