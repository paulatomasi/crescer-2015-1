using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication
{
    class Program
    {
        string _variavel;

        static void Main(string[] args)
        {
            #region dynamic
            dynamic oi = "Ta se loco!";
            oi += 10;
            Console.WriteLine(oi);
            #endregion

            #region array
            var numeros = new[] { 1, 2, 3 }.ToList();
            /* transforma o arraiii numa lista */
            // numeros.Add(4);
            // var numeros = new List<int>(capacity: 10);     

            string str1 = "Ana";

            /*for (int i = 0; i < 10000; i++)
            {
                Console.WriteLine(i);
                // breakpoint condicional i > 7000
                // Shift + F5 --> para o debug
            }*/

            // C# mito já sabe o tipo do arraiii VAR
            //foreach (var i in numeros)
            //{
            //    console.writeline(i);
            //}

            Action<int> imprimir = i => Console.WriteLine(i + " bacon");

            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);

            /* numeros.ForEach((i) =>
                {
                    Console.WriteLine(i);
                });*/

            #endregion

            #region Extension Methods
            Console.WriteLine("Ana".ToBacon());
            #endregion

            #region Jedi
            //yoda.Nome = "Yoda";
            var yoda = new Jedi
            {
                Nome = "Yoda",
                Grau = Grau.MESTRE
            };

            var baconJedi = new
            {
                Nome = yoda.Nome.ToBacon()
            };

            Console.WriteLine(yoda.Nome);
            #endregion

            #region DateTime
            DateTime agora = DateTime.Now;

            Console.WriteLine(agora);
            #endregion

            Console.ReadLine();
        }
    }
}