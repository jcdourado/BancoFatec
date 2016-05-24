package model;

import java.util.Date;

public class Conta {
	private int id;
	private String tipo;
	private String numero;
	private float saldo;
	private float limite;
	private float taxaServico;
	private float taxaJuros;
	private float taxaRendimento;
	private Date dataAbertura;
	private float diaRendimento;
	private String nomeGerente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	public float getTaxaServico() {
		return taxaServico;
	}
	public void setTaxaServico(float taxaServico) {
		this.taxaServico = taxaServico;
	}
	public float getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public float getTaxaRendimento() {
		return taxaRendimento;
	}
	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public float getDiaRendimento() {
		return diaRendimento;
	}
	public void setDiaRendimento(float diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	public String getNomeGerente() {
		return nomeGerente;
	}
	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
}
