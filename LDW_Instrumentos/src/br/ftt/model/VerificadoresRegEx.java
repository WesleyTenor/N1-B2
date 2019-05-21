package br.ftt.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VerificadoresRegEx {

    private static Pattern verificadorIDs = Pattern.compile("(^[1-9]*)$"); 

    private static Pattern verificadorDescricaoComponente = Pattern.compile("(^(([a-zA-Z]{3,}(\\s[a-zA-Z]+)+)+))$");

    private static Pattern verificadorDataPedido = Pattern.compile("^((((0[1-9]|[1-2]\\d|3[0-1])\\/(0[1-9]|1[0-2]))|((0[1-9]|1[0-2])\\/(0[1-9]|[1-2]\\d|3[0-1])))(\\/[12]\\d{3}))$");

    private static Pattern verificadorCPF = Pattern.compile("^(([1-9]{3})\\.\\d{3}\\.\\d{3}\\.\\d{2})$");

    private static Pattern verificadorCNPJ = Pattern.compile("^([1-9]{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})$");

    private static Pattern verificadorDinheiro = Pattern.compile("^(([R]\\$)\\d+\\,\\d{2})$");

    private static Pattern verificadorQuatidade = Pattern.compile("^(\\d+)$");

    private static Pattern verificadorLote = Pattern.compile("^((\\w){5,8})$");

    private static Pattern verificadorNome = Pattern.compile("^([A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+)$");

     private static Pattern verificadorCidade = Pattern.compile("^([A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+)$");
    
    private static Pattern verificadorCEP = Pattern.compile("^(\\d{5}-\\d{3})$");

    private static Pattern verificadorNomeDaEmpresa = Pattern.compile("^([A-ZÀ-Ÿ0-9][A-zÀ-ÿ'0-9]+\\s?([A-zÀ-ÿ'0-9]\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+)$");

    private static Pattern verificadorRasaoSocial = Pattern.compile("^([A-ZÀ-Ÿ0-9][A-zÀ-ÿ'0-9]+\\s?([A-zÀ-ÿ'0-9]\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+)$");

    private static Pattern verificadorEndereco = Pattern.compile("^((RUA|Rua|R.|AVENIDA|Avenida|AV.|TRAVESSA|Travessa|TRAV.|Trav.)([a-zA-Z\\s]+)[\\,]\\s?(\\d+))$");

    private static Pattern verificadorBairro = Pattern.compile("^[A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+$");

    private static Pattern verificadorValorNominal = Pattern.compile("^([0-9]+\\s(coulomb|Coulomb|C|Volt|volt|V|ohm|Ohm|Ω|Joule|joule|J|Watt|watt|W|Ampere|ampere|A|Kelvin|kelvin|K))$");

    private static Pattern getVerificadorIDs() {
        return verificadorIDs;
    }//

    private static Pattern getVerificadorDescricaoComponente() {
        return verificadorDescricaoComponente;
    }//

    private static Pattern getVerificadorDataPedido() {
        return verificadorDataPedido;
    }//

    private static Pattern getVerificadorCPF() {
        return verificadorCPF;
    }//

    private static Pattern getVerificadorCNPJ() {
        return verificadorCNPJ;
    }//

    private static Pattern getVerificadorDinheiro() {
        return verificadorDinheiro;
    }//

    private static Pattern getVerificadorQuatidade() {
        return verificadorQuatidade;
    }//

    private static Pattern getVerificadorLote() {
        return verificadorLote;
    }//

    private static Pattern getVerificadorNome() {
        return verificadorNome;
    }//

    private static Pattern getVerificadorCEP() {
        return verificadorCEP;
    }//

    private static Pattern getVerificadorNomeDaEmpresa() {
        return verificadorNomeDaEmpresa;
    }//

    private static Pattern getVerificadorRasaoSocial() {
        return verificadorRasaoSocial;
    }//

    private static Pattern getVerificadorEndereco() {
        return verificadorEndereco;
    }//

    private static Pattern getVerificadorBairro() {
        return verificadorBairro;
    }//

    private static Pattern getVerificadorValorNominal() {
        return verificadorValorNominal;
    }//
    
    private static Pattern getVerificadorCidade(){
        return verificadorCidade;
    }//

//---Matchers--
    public static Matcher getMatcherVerificadorIDs(String entrada) {
        Matcher matcherIDs = getVerificadorIDs().matcher(entrada);
        return matcherIDs;
    }

    public static Matcher getVerificadorDescricaoComponente(String entrada) {
        Matcher matcherDescricaoComponente = getVerificadorDescricaoComponente().matcher(entrada);
        return matcherDescricaoComponente;
    }

    public static Matcher getMatcherDataPedido(String entrada) {
        Matcher matcherDataPedido = getVerificadorDataPedido().matcher(entrada);
        return matcherDataPedido;
    }

    public static Matcher getMatcherVerificadorCPF(String entrada) {
        Matcher matcherVerificadorCPF = getVerificadorCPF().matcher(entrada);
        return matcherVerificadorCPF;
    }

    public static Matcher getMatcherVerificadorCNPJ(String entrada) {
        Matcher matcherVerificadorCNPJ = getVerificadorCNPJ().matcher(entrada);
        return matcherVerificadorCNPJ;
    }

    public static Matcher getMatcherVerificadorDinheiro(String entrada) {
        Matcher matcherVerificadorDinheiro = getVerificadorDinheiro().matcher(entrada);
        return matcherVerificadorDinheiro;
    }

    public static Matcher getMatcherVerificadorQuatidade(String entrada) {
        Matcher matcherVerificadorQuatidade = getVerificadorQuatidade().matcher(entrada);
        return matcherVerificadorQuatidade;
    }

    public static Matcher getMatcherVerificadorLote(String entrada) {
        Matcher matcherVerificadorLote = getVerificadorLote().matcher(entrada);
        return matcherVerificadorLote;
    }

    public static Matcher getMatcherVerificadorNome(String entrada) {
        Matcher matcherVerificadorNome = getVerificadorNome().matcher(entrada);
        return matcherVerificadorNome;
    }

    public static Matcher getMatcherVerificadorCEP(String entrada) {
        Matcher matcherVerificadorCEP = getVerificadorCEP().matcher(entrada);
        return matcherVerificadorCEP;
    }

    public static Matcher getMatcherVerificadorNomeDaEmpresa(String entrada) {
        Matcher matcherVerificadorNomeDaEmpresa = getVerificadorNomeDaEmpresa().matcher(entrada);
        return matcherVerificadorNomeDaEmpresa;
    }

    public static Matcher getMatcherVerificadorRasaoSocial(String entrada) {
        Matcher matcherVerificadorRasaoSocial = getVerificadorRasaoSocial().matcher(entrada);
        return matcherVerificadorRasaoSocial;
    }

    public static Matcher getMatcherVerificadorEndereco(String entrada) {
        Matcher matcherVerificadorEndereco = getVerificadorEndereco().matcher(entrada);
        return matcherVerificadorEndereco;
    }

    public static Matcher getMatcherVerificadorBairro(String entrada) {
        Matcher matcherVerificadorBairro = getVerificadorBairro().matcher(entrada);
        return matcherVerificadorBairro;
    }

    public static Matcher getMatcherVerificadorValorNominal(String entrada) {
        Matcher matcherVerificadorValorNominal = getVerificadorValorNominal().matcher(entrada);
        return matcherVerificadorValorNominal;
    }
    
    public static Matcher getMatcherVerificadorCidade(String entrada) {
        Matcher matcherVerificadorCidade = getVerificadorCidade().matcher(entrada);
        return matcherVerificadorCidade;
    }
}
