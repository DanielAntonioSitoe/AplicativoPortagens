package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Notificacoes;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Portagem;
import com.example.aplicativoportagens.modelo.Solicitacoes;
import com.example.aplicativoportagens.modelo.Turnos;
import com.example.aplicativoportagens.modelo.Usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controler {

  UsuarioDAO usuarioDAO = new UsuarioDAO();
  EquipamentosDAO equipamentosDAO = new EquipamentosDAO();
  OcorenciasDAO ocorenciasDAO = new OcorenciasDAO();
  PortagemDAO portagemDAO = new PortagemDAO();
  SolicitacoesDAO solicitacoesDAO = new SolicitacoesDAO();
  TurnosDAO turnosDAO = new TurnosDAO();
  NotificacoesDAO notificacoesDAO = new NotificacoesDAO();
  CheckInDAO checkInDAO = new CheckInDAO();
  Usuario usuario;
  Equipamentos equipamentos;
  Ocorencias ocorencias;
  Solicitacoes solicitacoes;
  Portagem portagem;
  Turnos turnos;
  Notificacoes notificacoes;


//  public void inicializarDados(){
//      for(int i=0;i<=4;i++){
//          usuario= new Usuario(0,"Daniel"+i,847464+i,"daniel","1234");
//          usuarioDAO.salvar(usuario);
//          portagem = new Portagem(0,"Portagem Costa do Sol",-25.123,25.4332);
//          portagemDAO.salvar(portagem);
//          equipamentos = new Equipamentos(0,"Camera ANPR "+i,"Camera","Ativo","Cabine1",portagemDAO.buscarUm(i+1));
//          equipamentosDAO.salvar(equipamentos);
//      }
//
//  }
}
