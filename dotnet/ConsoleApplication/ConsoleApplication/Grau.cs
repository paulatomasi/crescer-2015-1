using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication
{
    enum Grau
    {
        [Description("Joven Padawan")]
        PADAWAN,
        [Description("Joven Cavaleiro")]
        CAVALEIRO,
        [Description("Joven Mestre")]
        MESTRE
    }
}
