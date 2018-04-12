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
    class SQLiteRepos
    {
        private GunContext gc;

        public SQLiteRepos() 
        {
            gc = new GunContext();
        }

        public List<Gun> ReturnList()
        {
            return gc.Guns.ToList();
        }

        public void ModifyState(Gun g)
        {
            gc.Entry(g).State = EntityState.Modified;
        }

        public void Save()
        {
            gc.SaveChanges();
        }

        public void Retrieve()
        {
            foreach (DbEntityEntry entry in gc.ChangeTracker.Entries())
            {
                if (entry.State == EntityState.Modified)
                    entry.State = EntityState.Unchanged;

            }
        }
    }
}
