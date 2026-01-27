@Controller
public class AccountController {

    private final AccountService accountService;
    private final TransactionService txnService;

    public AccountController(AccountService accountService, TransactionService txnService) {
        this.accountService = accountService;
        this.txnService = txnService;
    }

    @PostMapping("/deposit")
    public String deposit(HttpServletRequest req, HttpSession session) {
        String uid = req.getParameter("uid");
        String am = req.getParameter("am");

        String res = accountService.deposit(uid, am);
        txnService.insertTxn(uid, "deposit", am);

        session.setAttribute("ac", accountService.readAccount(uid));
        session.setAttribute("msg", res.equals("updated") ? "Money deposited" : "Failed");
        return "redirect:/account.jsp";
    }

    @PostMapping("/withdraw")
    public String withdraw(HttpServletRequest req, HttpSession session) {
        String uid = req.getParameter("uid");
        String am = req.getParameter("am");

        String res = accountService.withdraw(uid, am);
        txnService.insertTxn(uid, "withdraw", am);

        session.setAttribute("ac", accountService.readAccount(uid));
        session.setAttribute("msg", res.equals("updated") ? "Money withdraw" : "Insufficient funds");
        return "redirect:/account.jsp";
    }

    @PostMapping("/transfer")
    public String transfer(HttpServletRequest req, HttpSession session) {
        String uid = req.getParameter("uid");
        String am = req.getParameter("am");
        String acb = req.getParameter("acb");

        String res = accountService.transfer(uid, am, acb);
        txnService.insertTxn(uid, "money transfer", am);

        session.setAttribute("ac", accountService.readAccount(uid));
        session.setAttribute("msg", res.equals("updated") ? "Money Transfered" : "Insufficient funds");
        return "redirect:/account.jsp";
    }
}

