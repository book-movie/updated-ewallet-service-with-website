package com.capgemini.bookmymovie.ewalletwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bookmymovie.ewalletwebsite.pojo.Ewallet;

@Controller
public class EwalletController {

	@Autowired
	RestTemplate template;
	
	
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
				
	}
	
	@RequestMapping("/create")
	public String create(@RequestParam("currentBalance") double currentBalance,Model model)
	{
		Ewallet wallet = new Ewallet();
		wallet.setCurrentBalance(currentBalance);
		ResponseEntity<String> entity = template.postForEntity("http://localhost:2727/wallets", wallet, String.class);
		model.addAttribute("message", entity.getStatusCode());
		return "home";
				
	}
	
	@RequestMapping("/statements")
	public String statements(Model model)
	{
		Ewallet statements = template.getForObject("http://localhost:2727/wallets/statements", Ewallet.class);
		model.addAttribute("statements", statements.getStatements());
		return "home";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("amount") double currentBalance)
	{
		template.put("http://localhost:2727/wallets/1?currentBalance="+currentBalance, null);
		return "home";
	}
	
	@RequestMapping("/updateBalance")
	public String updatebalance()
	{
		return "update";
	}
	
}
