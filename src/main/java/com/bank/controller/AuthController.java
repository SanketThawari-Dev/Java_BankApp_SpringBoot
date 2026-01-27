@Controller
public class AuthController {

    private final AccountService accountService;
    private final TransactionService txnService;

    public AuthController(AccountService accountService, TransactionService txnService) {
        this.accountService = accountService;
        this.txnService = txnService;
    }

    @PostMapping("/signup")
    public String signup(HttpServletRequest req, HttpSession session) {
        String uid = req.getParameter("uid");

        txnService.createTxnTable(uid);
        String res = accountService.insert(req);

        if ("inserted".equals(res)) {
            session.setAttribute("msg", "Account created");
            return "redirect:/login.jsp";
        }
        session.setAttribute("msg", "Account Creation Failed");
        return "redirect:/signup.jsp";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, HttpSession session) {
        session.removeAttribute("msg");

        String uid = req.getParameter("uid");
        String upass = req.getParameter("upass");

        if ("exits".equals(accountService.checkUser(uid, upass))) {
            session.setAttribute("check", uid);
            session.setAttribute("ac", accountService.readAccount(uid));
            return "redirect:/account.jsp";
        }
        session.setAttribute("msg", "Invalid Userid or password");
        return "redirect:/login.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("check");
        return "redirect:/login.jsp";
    }
}

