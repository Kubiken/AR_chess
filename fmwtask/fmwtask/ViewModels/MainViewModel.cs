using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;

namespace fmwtask.Views
{
    class MainViewModel:BaseViewModel
    {
        #region Props
        GunContext gc;// Контекст БД
        private ObservableCollection<Gun> lwContent; //Контент ListView
        public ObservableCollection<Gun> LwContent
        {
            get { return lwContent; }
            set
            {
                lwContent = value;
                OnPropertyChanged("LwContent");
            }
        }

        private Gun selectedItem; // Выбраный в ListView элемент
        public Gun SelectedItem
        {
            get { return selectedItem; }
            set
            {
                selectedItem = value;
                OnPropertyChanged("SelectedItem");

                gc.Entry(SelectedItem).State = EntityState.Modified;
            }
        }
        #endregion
        #region Commands
        public IDelegateCommand SaveChanges { get; set; } //Комманда для сохранения изменений
        void ExecuteSaveChanges(object param)
        {
            this.gc.SaveChanges();
        } //Параметры выполнения комманды SaveChanges

        public IDelegateCommand RemoveChanges { get; set; } //Комманда для отката изменений
        void ExecuteRemoveChanges(object param)
        {
            foreach (DbEntityEntry entry in gc.ChangeTracker.Entries())
            {
                if (entry.State == EntityState.Modified)
                    entry.State = EntityState.Unchanged;
                SelectedItem = LwContent[0];
            }
            
        } //Параметры выполнения комманды RemoveChanges
        #endregion 
        public MainViewModel()
        {
            gc = new GunContext();
            List<Gun> buf = gc.Guns.ToList();
            LwContent = new ObservableCollection<Gun>(buf);
            this.SaveChanges = new DelegateCommand(ExecuteSaveChanges);
            this.RemoveChanges = new DelegateCommand(ExecuteRemoveChanges);
            
        }
    }
}
