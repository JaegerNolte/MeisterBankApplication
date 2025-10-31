package com.project.demo.account;

public class AccountModel {

    private long accountId;
    private long accountTypeId;
    private String accountNickname;


    public AccountModel() {

    }


    public AccountModel(long appUserId, long accountTypeId, String accountNickname) {
        this.accountTypeId = accountTypeId;
        this.accountNickname = accountNickname;
    }


    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public void setAccountNickname(String accountNickname) {
        this.accountNickname = accountNickname;
    }


    @Override
    public String toString() {
        return "AccountModel{" +
                "accountId=" + accountId +
                ", accountTypeId=" + accountTypeId +
                ", accountNickname='" + accountNickname + '\'' +
                '}';
    }

}
