package controller;

import view.*;
import model.User;

public class DashboardController {

    // Constructor connects dashboard buttons with actions
    public DashboardController(DashboardView view, User user) {

        // Open Product screen
        view.btnProducts.addActionListener(e ->
            new ProductController(new ProductView())
        );

        // Open User screen
        view.btnUsers.addActionListener(e ->
            new UserController(new UserView())
        );

        // Open Stock Report screen
        view.btnReport.addActionListener(e ->
            new StockReportController(new StockReportView())
        );
    }
}
