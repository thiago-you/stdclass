package you.thiago.stdclass;

import java.util.ArrayList;

/**
 * ArrayList<StdObject> collections
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class StdCollections {

    public static final Integer NULL_INT_VALUES = -1;

    /**
     * Retorna a lista de "UF" disponíveis
     */
    public static ArrayList<StdObject> getUfList(final boolean withEmptyValue) {
        return new ArrayList<StdObject>() {{
            if (withEmptyValue) {
                add(new StdObject(-1, ""));
            }

            add(new StdObject(0, "Acre").setExtra("AC"));
            add(new StdObject(1, "Alagoas").setExtra("AL"));
            add(new StdObject(2, "Amapá").setExtra("AP"));
            add(new StdObject(3, "Amazonas").setExtra("AM"));
            add(new StdObject(4, "Bahia").setExtra("BA"));
            add(new StdObject(5, "Ceará").setExtra("CE"));
            add(new StdObject(6, "Distrito Federal").setExtra("DF"));
            add(new StdObject(7, "Espírito Santo").setExtra("ES"));
            add(new StdObject(8, "Goiás").setExtra("GO"));
            add(new StdObject(9, "Maranhão").setExtra("MA"));
            add(new StdObject(10, "Mato Grosso").setExtra("MT"));
            add(new StdObject(11, "Mato Grosso do Sul").setExtra("MS"));
            add(new StdObject(12, "Minas Gerais").setExtra("MG"));
            add(new StdObject(13, "Pará").setExtra("PA"));
            add(new StdObject(14, "Paraíba").setExtra("PB"));
            add(new StdObject(15, "Paraná").setExtra("PR"));
            add(new StdObject(16, "Pernambuco").setExtra("PE"));
            add(new StdObject(17, "Piauí").setExtra("PI"));
            add(new StdObject(18, "Rio de Janeiro").setExtra("RJ"));
            add(new StdObject(19, "Rio Grande do Norte").setExtra("RN"));
            add(new StdObject(20, "Rio Grande do Sul").setExtra("RS"));
            add(new StdObject(21, "Rondônia").setExtra("RO"));
            add(new StdObject(22, "Roraima").setExtra("RR"));
            add(new StdObject(23, "Santa Catarina").setExtra("SC"));
            add(new StdObject(24, "São Paulo").setExtra("SP"));
            add(new StdObject(25, "Sergipe").setExtra("SE"));
            add(new StdObject(26, "Tocantins").setExtra("TO"));
        }};
    }

    /**
     * Retorna a lista de "Cor de Pele" disponíveis
     */
    public static ArrayList<StdObject> getCorPeleList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(-1, ""));
            add(new StdObject(1, "Afro-Brasileiro"));
            add(new StdObject(2, "Branca"));
            add(new StdObject(3, "Indígena"));
            add(new StdObject(4, "Amarela"));
            add(new StdObject(5, "Parda"));
        }};
    }

    /**
     * Retorna a lista de "Estado Cívil" disponíveis
     */
    public static ArrayList<StdObject> getEstadoCivilList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
            add(new StdObject(0, "Solteiro"));
            add(new StdObject(1, "Casado"));
            add(new StdObject(2, "Viúvo"));
            add(new StdObject(3, "Separado Judicialmente"));
            add(new StdObject(4, "Divorciado"));
        }};
    }

    /**
     * Retorna a lista de "Nível de Escolaridade" disponíveis
     */
    public static ArrayList<StdObject> getNivelEscolaridadeList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
            add(new StdObject(0, "Fundamental Incompleto"));
            add(new StdObject(1, "Fundamental Completo"));
            add(new StdObject(2, "Médio Incompleto"));
            add(new StdObject(3, "Médio Completo"));
            add(new StdObject(4, "Superior Incompleto"));
            add(new StdObject(5, "Superior Completo"));
            add(new StdObject(6, "Pós-Graduação Incompleto"));
            add(new StdObject(7, "Pós-Graduação Completo"));
            add(new StdObject(8, "Mestrado Incompleto"));
            add(new StdObject(9, "Mestrado Completo"));
            add(new StdObject(10, "Doutorado Incompleto"));
            add(new StdObject(11, "Doutorado Completo"));
        }};
    }

    /**
     * Retorna a lista de "Quantidade de Filhos" disponíveis
     */
    public static ArrayList<StdObject> getQuantidadeFilhosList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
            add(new StdObject(0, "0 Nenhum Filho"));
            add(new StdObject(1, "1 Filho"));
            add(new StdObject(2, "2 Filhos"));
            add(new StdObject(3, "3 Filhos"));
            add(new StdObject(4, "4 Filhos"));
            add(new StdObject(5, "5 Filhos"));
            add(new StdObject(6, "6 Ou Mais Filhos"));
        }};
    }

    /**
     * Retorna a lista de "Renda Mensal" disponíveis
     */
    public static ArrayList<StdObject> getRendaMensalList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(9, "Não Registrado", true));
            add(new StdObject(0, "Até 1 Salário Mínimo"));
            add(new StdObject(1, "De 1 a 2 Salário Mínimos"));
            add(new StdObject(2, "De 2 a 3 Salário Mínimos"));
            add(new StdObject(3, "De 3 a 5 Salário Mínimos"));
            add(new StdObject(4, "De 5 a 10 Salário Mínimos"));
            add(new StdObject(5, "De 10 a 20 Salário Mínimos"));
            add(new StdObject(6, "Mais de 20 Salário Mínimos"));
            add(new StdObject(7, "Sem Rendimento"));
            add(new StdObject(8, "Não Soube Informar"));
        }};
    }

    /**
     * Retorna a lista de "Marcação do Combustível" disponíveis
     */
    public static ArrayList<StdObject> getCombustivelList() {
        return new ArrayList<StdObject>() {{
            add(new StdObject(0, "E"));
            add(new StdObject(1, "1/4"));
            add(new StdObject(2, "1/2"));
            add(new StdObject(3, "1/3"));
            add(new StdObject(4, "C"));
        }};
    }
}
