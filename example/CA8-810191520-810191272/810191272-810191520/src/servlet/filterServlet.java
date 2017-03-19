package servlet;

import exception.MismatchedParametersException;
import exception.NotEnoughCreditException;
import exception.RepeatedIdException;
import exception.UnknownUserIdException;
import logic.Core;
import dao.ExchangeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class filterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lowerPrice = request.getParameter("lowerPrice");
        //if(lowerPrice.equals(""))
        //    lowerPrice = "%";

        String upperPrice = request.getParameter("upperPrice");
        //if(upperPrice.equals(""))
        //    upperPrice = "%";

        String id = request.getParameter("id");
        //if(id.equals(""))
        //    id = "%";

        String name = request.getParameter("name");
        //if(name.equals(""))
        //    name = "%";

        String symbol = request.getParameter("symbol");
        //if(symbol.equals(""))
        //    symbol = "%";

        String fromDate = request.getParameter("fromDate");
        //if(fromDate.equals(""))
        //    fromDate = "%";

        String toDate = request.getParameter("toDate");
        //if(toDate.equals(""))
        //    toDate = "%";

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        String info = service.JsonServices.getInstance().filterExchanges(lowerPrice, upperPrice, id, name, symbol, fromDate, toDate);
        //System.out.println(info);

        out.print(info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
