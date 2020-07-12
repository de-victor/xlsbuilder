# # XLSBUIDER
> Estudo de design pattern pipeline com JAVA

Um pequeno estudo de caso com a implementação do design pattern pipeline com java. Neste estudo foi utilizado a lib jxl para geração de um arquivo xls. <br/>
O uso desse design pattern tem como objetivo simplificar a utilização do que seria o passo a passo da criação de uma planilha em xls.

## Exemplo de uso


    File file = new File("tmp.xls");

    List<List<String>> data = loadData(alunoRepository.getAll());

    XlsMaker.createWorkbook(file)
            .createSheet("Relatório", 0)
            .createHeader(new String[]{"id", "matricula", "nome", "responsavel", "tel1", "tel2"})
            .fillData(data)
            .buildAndWriteFile();

