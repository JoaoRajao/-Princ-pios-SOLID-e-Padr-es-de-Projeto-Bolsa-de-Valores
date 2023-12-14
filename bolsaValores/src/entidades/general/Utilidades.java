package entidades.general;

import entidades.Excecoes.FormatoNaoValidoExcecao;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Utilidades {

    public static double numeroAleatorio() {
        return Math.random();
    }

    public static Object[] deserializar(String mensagem, int comprimento, String tipo) throws FormatoNaoValidoExcecao {
        String[] campos = mensagem.split("\\|");
        Object[] camposMensagem = new Object[comprimento];

        if (campos.length < comprimento) {
            throw new FormatoNaoValidoExcecao();
        }

        try {
            camposMensagem[0] = Integer.parseInt(campos[0]);
            camposMensagem[1] = campos[1];
            camposMensagem[2] = campos[2];

            if (comprimento == 4) {
                if ("Compra".equals(tipo)) {
                    camposMensagem[3] = Double.parseDouble(campos[3]);
                } else {
                    camposMensagem[3] = Integer.parseInt(campos[3]);
                }
            }
        } catch (NumberFormatException e) {
            throw new FormatoNaoValidoExcecao();
        }

        return camposMensagem;
    }

    public static String converterParaString(ArrayList<Object> array) {
        StringJoiner sj = new StringJoiner("|");

        for (Object objeto : array) {
            if (objeto instanceof String) {
                sj.add((String) objeto);
            } else if (objeto instanceof Integer) {
                sj.add(Integer.toString((Integer) objeto));
            } else if (objeto instanceof Boolean) {
                sj.add(Boolean.toString((Boolean) objeto));
            } else if (objeto instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objeto;
                StringBuilder sb = new StringBuilder("");

                if (arrayList.get(0) instanceof String) {
                    for (Object o : arrayList) {
                        sb.append((String) o);
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                } else if (arrayList.get(0) instanceof Double) {
                    for (Object o : arrayList) {
                        sb.append(Double.toString((Double) o));
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                }

                sj.add(sb.toString());
            } else {
                sj.add(Double.toString((Double) objeto));
            }
        }

        return sj.toString();
    }

    public static double arredondarDecimais(double valorInicial, int numeroDecimais) {
        double parteInteira, resultado;
        resultado = valorInicial;
        parteInteira = Math.floor(resultado);
        resultado = (resultado - parteInteira) * Math.pow(10, numeroDecimais);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimais)) + parteInteira;
        return resultado;
    }
}
