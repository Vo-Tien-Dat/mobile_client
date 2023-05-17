package com.hoanganhnhan.catalog.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Account implements Serializable {
    @PropertyName("account_id")
    public String accountId;
    @PropertyName("account_username")
    public String accountUsername;
    @PropertyName("account_password")
    public String accountPassword;
    @PropertyName("account_role")
//    Role 0 = client, 1 = admin
    public int accountRole;
    @PropertyName("account_full_name")
    public String accountFullName;
    @PropertyName("account_date_of_birth")
    public String accountDateOfBirth;
    @PropertyName("account_email")
    public String accountEmail;
    @PropertyName("account_phone_number")
    public String accountPhoneNumber;
    @PropertyName("account_user_image")
    public String accountUserImage;

    public Account() {
    }

    public Account(String accountId, String accountUsername, String accountPassword, int accountRole, String accountFullName, String accountDateOfBirth, String accountEmail, String accountPhoneNumber, String accountUserImage) {
        this.accountId = accountId;
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountRole = accountRole;
        this.accountFullName = accountFullName;
        this.accountDateOfBirth = accountDateOfBirth;
        this.accountEmail = accountEmail;
        this.accountPhoneNumber = accountPhoneNumber;
        this.accountUserImage = accountUserImage;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public int getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(int accountRole) {
        this.accountRole = accountRole;
    }

    public String getAccountFullName() {
        return accountFullName;
    }

    public void setAccountFullName(String accountFullName) {
        this.accountFullName = accountFullName;
    }

    public String getAccountDateOfBirth() {
        return accountDateOfBirth;
    }

    public void setAccountDateOfBirth(String accountDateOfBirth) {
        this.accountDateOfBirth = accountDateOfBirth;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPhoneNumber() {
        return accountPhoneNumber;
    }

    public void setAccountPhoneNumber(String accountPhoneNumber) {
        this.accountPhoneNumber = accountPhoneNumber;
    }

    public String getAccountUserImage() {
        return accountUserImage;
    }

    public void setAccountUserImage(String accountUserImage) {
        this.accountUserImage = accountUserImage;
    }
}
