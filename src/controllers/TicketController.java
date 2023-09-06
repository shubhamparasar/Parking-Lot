package controllers;

import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;


public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){

        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        Ticket responseTicket = ticketService.issueTicket(issueTicketRequestDto.getVehicleType(),
                issueTicketRequestDto.getVehicleNumber(),
                issueTicketRequestDto.getOwnersName(),
                issueTicketRequestDto.getGateId());

        issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        issueTicketResponseDto.setTicket(responseTicket);
        return issueTicketResponseDto;
    }
}
