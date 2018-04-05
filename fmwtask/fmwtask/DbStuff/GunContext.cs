using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace fmwtask
{
    class GunContext:DbContext
    {
        public GunContext()
            :base("DbConnection")
        { }

        public DbSet<Gun> Guns { get; set; }
    }
}
