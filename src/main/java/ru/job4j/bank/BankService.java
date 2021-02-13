package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {

        Optional<User> rsl = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        if (rsl.isEmpty()) {
            rsl = Optional.empty();
        }

        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {

        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = users.get(user.get()).stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst();
        if (rsl.isEmpty()) {
            rsl = Optional.empty();
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;

        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            double srcBalance = srcAccount.get().getBalance();

            if (srcBalance >= amount) {
                double destBalans = destAccount.get().getBalance();
                srcAccount.get().setBalance(srcBalance - amount);
                destAccount.get().setBalance(destBalans + amount);
                rsl = true;
            }
        }

        return rsl;
    }
}
