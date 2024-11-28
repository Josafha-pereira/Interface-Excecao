/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfacejava;


public class InterfaceJava {

   
    // interface Automovel
    public interface Automovel {
        void AbastecerVeiculo(double litros); //abastecer o veículo
        double GetCombustivel(); //saber o tanto atual de combustível
        double ConsumoPorKm();  // retorna o consumo de combustível do veículo em litros por quilômetro
        void CombustivelGasto(double quantidade); //subtrair uma quantidade específica de combustível apos uma viagem
    }

    // classe Carro implementa a interface Automovel
    public static class Carro implements Automovel {
        private double combustivel = 0;// armazena o nível atual de combustível no carro

        // implementação do método abastecer, que abastece o carro com "n" litros
        @Override
        public void AbastecerVeiculo(double litros) {
            combustivel += litros; // apos colocar "n" litros, o combustivel tera agora combustivel + n litros novos
            System.out.printf("Carro abastecido com %.1f litros\nCombustível total: %.1f litros\n", litros, combustivel);
        }
    
        //o metodo implementado retorna o nível atual de combustível
        @Override
        public double GetCombustivel() {
            return combustivel;
        }
    
        //retorna o consumo do carro em litros por quilômetro
        @Override
        public double ConsumoPorKm() {
            return 1.0 / 15.0; // Consumo de 1 litro a cada 15 km
        }
    
        // Reduz a quantidade de combustível apos uma viagem realizada
        @Override
        public void CombustivelGasto(double quantidade) {
            combustivel -= quantidade; // combustivel vai ser diminuido em "n" quantidades, que foram necessarias para realizar a(s) viagem(ns)
        }
    }

    // Classe Moto que implementa Automovel
    public static class Moto implements Automovel {
        private double combustivel = 0;// armazena o nível atual de combustível na moto

        // implementação do método abastecer, que abastece da moto com "n" litros
        @Override
        public void AbastecerVeiculo(double litros) {
            combustivel += litros; // apos colocar "n" litros, o combustivel tera agora combustivel + n litros novos
            System.out.printf("\nMoto abastecida com %.1f litros\nCombustível total: %.1f litros\n", litros, combustivel);
        }

        //o metodo implementado retorna o nível atual de combustível
        @Override
        public double GetCombustivel() {
            return combustivel;
        }

        //retorna o consumo da moto em litros por quilômetro
        @Override
        public double ConsumoPorKm() {
            return 1.0 / 10.0; // Consumo de 1 litro a cada 10 km
        }

        // Reduz a quantidade de combustível apos uma viagem realizada
        @Override
        public void CombustivelGasto(double quantidade) {
            combustivel -= quantidade; // combustivel vai ser diminuido em "n" quantidades que foram necessarias para realizar a(s) viagem(ns)
        }
    }

    // Calcula a quantidade de combustível necessária para a viagem com base na distância e consumo por km
    public static boolean realizarViagem(Automovel auto, double distancia) {
        double combustivelNecessario = distancia * auto.ConsumoPorKm();
    
        // Verifica se o automóvel possui combustível suficiente para a viagem,se  ao tiver, retorna falso para viajar
        if (auto.GetCombustivel() < combustivelNecessario) {
            System.out.println("\nCOMBUSTIVEL INSUFICIENTE!!\n");
            return false;
        }
    
        // Caso tenha combustivel o suficiente, a viagem sera realizada e sera consumido o combustível necessário
        auto.CombustivelGasto(combustivelNecessario);
        System.out.printf("\n\nViagem realizada!\nDistância: %.1f km\nCombustível restante: %.1f litros\n", distancia, auto.GetCombustivel());
        System.out.print("---------------------------------------------------------------------------------------------------------------------");
        return true;
    }

    // Função principal
    public static void main(String[] args) {
        // Cria um array de objetos do tipo Automovel
        Automovel[] veiculos = {
            new Carro(),
            new Moto()
        };

        double DistanciaDaViagem = 100.0;
    
        // Itera sobre o array e realiza ações em cada automóvel
        for (Automovel auto:veiculos) {
            auto.AbastecerVeiculo(20);
            realizarViagem(auto, DistanciaDaViagem);
            
        }
        
        
    }
    

}
    
    

