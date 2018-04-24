using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;

namespace fmwtask
{
    class SQLiteRepos<T> where T: class
    {
        public AppContext<T> Context;

        public SQLiteRepos() 
        {
            Context = new AppContext<T>();
        }

        public void Save()
        {
            Context.SaveChanges();
        }

        public void Retrieve()
        {
            foreach (DbEntityEntry entry in Context.ChangeTracker.Entries())
            {
                if (entry.State == EntityState.Modified)
                    entry.State = EntityState.Unchanged;

            }
        }
    }
}
