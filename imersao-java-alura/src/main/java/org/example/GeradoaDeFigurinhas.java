package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GeradoaDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        //leitura da imagem
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        //InputStream inputStream = new FileInputStream("src/entrada/google.png");

        BufferedImage imagemOriginal =  ImageIO.read(inputStream);

        // criar imagem com trasnparencia e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);

        //copiar imagem original para nova imagem em memoria

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0,0,null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem

        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        //escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem,"png", new File("saida/figurinha.png"));
    }
}
