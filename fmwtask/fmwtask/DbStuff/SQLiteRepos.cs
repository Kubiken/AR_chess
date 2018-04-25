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
    class SQLiteRepos<T> where T:class, IIdfield
    {
        private AppContext<T> Context;

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

        public List<T>Load ()
        {
            return Context.List.ToList<T>();
        }

        public T LoadById (long id)
        {
            var obj = Context.List.Where<T>(c => c.Id == id);
            return (T)obj;
        }

        public List<T> LoadByLinq(Func<T, bool> filter)
        {
            List<T> result = new List<T>();
            var subres = Context.List.Where(filter);
            foreach (var obj in subres)
            {
                result.Add(obj);
            }
            return result;
        }
    }
}
