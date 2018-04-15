using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace fmwtask
{
    class AppContext<T>:DbContext where T: class
    {
        public AppContext()
            :base("DbConnection")
        { }

        public DbSet<T> List { get; set; }
    }
}
